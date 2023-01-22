import React, { useState, useEffect } from "react";
import "./Dashboard.css";
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";
import { Doughnut } from "react-chartjs-2";
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from "chart.js";

const Dashboard = () => {
	var id = JSON.parse(localStorage.getItem("id"));
	const navigate = useNavigate();
	const logOutHandler = () => {
		localStorage.clear();
		navigate("/");
	};

	const [chartData, setChartData] = useState([]);

	useEffect(() => {
		fetchChartData(id).then((data) => {
			const config = {
				type: "doughnut",
				data: data,
			};
			setChartData(config);
		});
	}, [id]);

	const fetchChartData = async (id) => {
		const res = await fetch(`http://localhost:8080/` + id + `/cash-flow`, {
			method: "GET",
			headers: { "Content-type": "application/json" },
		});
		const jsonMessage = await res.json();
		console.log(JSON.parse(JSON.stringify(jsonMessage)));
		return JSON.parse(JSON.stringify(jsonMessage));
	};

	return (
		<div className="bg-white">
			<div className="container-fluid">
				<div className="row">
					<nav
						id="sidebarMenu"
						className="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse"
						style={{ height: "100%" }}
					>
						<div className="position-sticky pt-3">
							<ul className="nav flex-column align-items-center">
								<li className="nav-item px-0 py-4">
									<a className="nav-link active p-0" aria-current="page" href="#">
										<span className="navbar-brand">
											<img src="logo.png" alt="" style={{ height: "70px" }} />
										</span>
										<span className="text-decoration-none fw-bold h4 m-0 p-0" id="company-name">
											f$AVINGS
										</span>
									</a>
								</li>

								<li className="nav-item px-0 py-4">
									<Link to="/suggestions" className="nav-link link">
										<i className="bi bi-graph-up h4"> </i>
										<span className="fw-bold m-0 p-0 h4 text-dark"> Dashboard</span>
									</Link>
								</li>

								<li className="nav-item px-0 py-4">
									<Link to="/suggestions" className="nav-link link">
										<i className="bi bi-cash-coin h4"> </i>
										<span className="fw-bold m-0 p-0 h4 text-dark"> Transactions</span>
									</Link>
								</li>
								<li className="nav-item px-0 py-4">
									<Link to="/suggestions" className="nav-link link">
										<i className="bi bi-file-bar-graph h4"> </i>
										<span className="fw-bold m-0 p-0 h4 text-dark"> Reports</span>
									</Link>
								</li>
								<li className="nav-item px-0 py-4">
									<Link to="/suggestions" className="nav-link link">
										<i className="bi bi-trophy h4"> </i>
										<span className="fw-bold m-0 p-0 h4 text-dark"> Goals</span>
									</Link>
								</li>
								<li className="nav-item px-0 py-4">
									<Link to="/suggestions" className="nav-link link">
										<i className="bi bi-sliders h4"> </i>
										<span className="fw-bold m-0 p-0 h4 text-dark"> Settings</span>
									</Link>
								</li>

								<li className="nav-item px-0 py-4">
									<Link to="/suggestions" className="nav-link link">
										<i className="bi bi-box-arrow-right h4"></i>
										<span className="fw-bold m-0 p-0 h4 text-dark"> Logout</span>
									</Link>
								</li>
							</ul>
						</div>
					</nav>

					<div className="col-md-9 ms-sm-auto col-lg-10 p-md-4 text-center">
						<div className="row">
							<div className="col-sm-6">
								<div className="row card m-3">
									<div className="card-body text-dark">
										<h3 className="card-title head">
											Cash Flow <i className="bi bi-wallet2"></i>
										</h3>
										<h6 className="card-subtitle m-1 text-muted">
											This chart compares your total cash flows i.e. Earnings vs Savings for the
											last month of your transactions.
										</h6>
										<p className="card-text fs-5">
											Hey! I am a 21-year-old Java developer and AI enthusiast. Want to work with
											me? Connect with me on LinkedIn&nbsp;
											<a href="https://www.linkedin.com/in/bhavya-ruparelia/" id="linked-in">
												<i className="bi bi-linkedin"></i>
											</a>
											. Know more about me by following the given link!
										</p>
									</div>
								</div>
							</div>
							<div className="col-sm-6">
								<div className="row card m-3">
									<div className="card-body text-dark">
										<h3 className="card-title head">
											Goal Completion <i className="bi bi-calendar2-check"></i>
										</h3>
										<h6 className="card-subtitle m-1 text-muted">
											This graph aims to provide you the current standing in terms of the provided
											financial transactions. These results may be used as a reminder to alter
											further course based on the comparisions drawn between Actual and Expected
											value.
										</h6>
										<p className="card-text fs-5"></p>
									</div>
								</div>
							</div>
						</div>
						<div className="row">
							<div className="col-sm">col-sm</div>
							<div className="col-sm">col-sm</div>
							<div className="col-sm">col-sm</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	);
};

export default Dashboard;
