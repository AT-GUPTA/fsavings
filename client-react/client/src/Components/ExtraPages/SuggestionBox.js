import React from "react";
import { Link } from "react-router-dom";
import Form from "./Form";
import "./Suggestions.css";

const SuggestionBox = () => {
	return (
		<div>
			<nav class="navbar navbar-expand-lg bg-light">
				<div class="container-fluid">
					<span className="text-decoration-none fw-bold h4 m-0 p-0" id="company-name">f$AVINGS</span>
					<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<Link to="/login" className="nav-item nav-link mx-3 link">
								Login <i class="bi bi-box-arrow-in-right"></i>
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
				<div className="suggestion-box container text-bg-light rounded-5">
					<h3 className="text-center pt-2 mt-2 fw-semibold">Feedback & Suggestions!</h3>
					<hr />
					<Form />
				</div>
			</div>
		</div>
	);
};

export default SuggestionBox;
