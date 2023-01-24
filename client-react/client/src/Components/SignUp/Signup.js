import React from "react";
import { Link } from "react-router-dom";
import SignupBox from "./SignupBox";
import "./Signup.css";

const Signup = () => {
	return (
		<div>
			<nav className="navbar navbar-expand-lg bg-light">
				<div className="container-fluid">
					<span className="text-decoration-none fw-bold h4 m-0 p-0" id="company-name">
						f$AVINGS
					</span>
					<button
						className="navbar-toggler"
						type="button"
						data-bs-toggle="collapse"
						data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent"
						aria-expanded="false"
						aria-label="Toggle navigation"
					>
						<span className="navbar-toggler-icon"></span>
					</button>
					<div className="collapse navbar-collapse" id="navbarSupportedContent">
						<ul className="navbar-nav me-auto mb-2 mb-lg-0">
							<Link to="/login" className="nav-item nav-link mx-3 link">
								Login <i className="bi bi-box-arrow-in-right"></i>
							</Link>
							<Link to="/suggestions" className="nav-item nav-link mx-3 link">
								Suggestions <i className="bi bi-pencil-square"></i>
							</Link>
							<Link to="/release-notes" className="nav-item nav-link mx-3 link">
								Release Notes <i className="bi bi-bar-chart-line"></i>
							</Link>
							<Link to="/credits" className="nav-item nav-link mx-3 link">
								Credits <i className="bi bi-arrow-bar-right"></i>
							</Link>
						</ul>
					</div>
				</div>
			</nav>
			<div>
				<div id="background-image"></div>
				<SignupBox />
			</div>
		</div>
	);
};

export default Signup;
