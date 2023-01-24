import React from "react";
import { Link } from "react-router-dom";
import "./ReleaseNotes.css";

const ReleaseNotes = () => {
	return (
		<div>
			<nav class="navbar navbar-expand-lg bg-light">
				<div class="container-fluid">
					<span className="text-decoration-none fw-bold h4 m-0 p-0" id="company-name">f$AVINGS</span>
					<button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
					data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
					aria-expanded="false" aria-label="Toggle navigation">
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
				<div id="release-background-image"></div>
				<h3 className="px-4 pt-4 fw-semibold">
					Releases <i className="bi bi-bar-chart-steps" style={{ color: "yellow" }}></i>
				</h3>
				<hr />
				<ul className="list-group list-group-flush">
					<li className="list-group-item list-release lead">
						<h5>Release 1.14</h5>
						<div className="fs-6 text-light">
							<ul>
								<li> First final version of application released on GitHub with readme file.</li>
								<li> Landing page updated with application details.</li>
							</ul>
						</div>
					</li>
					<li className="list-group-item list-release lead">
						<h5>Release 1.13</h5>
						<div className="fs-6 text-light">
							<ul>
								<li> Quill API used to provide different formatting to notes.</li>
								<li> Notes functionality added to Home page after login.</li>
							</ul>
						</div>
					</li>
					<li className="list-group-item list-release lead">
						<h5>Release 1.12</h5>
						<div className="fs-6 text-light">
							<ul>
								<li> Removed bugs and errors from Home page</li>
								<li> Different functionality added with database.</li>
							</ul>
						</div>
					</li>
					<li className="list-group-item list-release lead">
						<h5>Release 1.11</h5>
						<div className="fs-6 text-light">
							<ul>
								<li> Database added for Login and Sign Up pages</li>
								<li> Release Notes page added.</li>
							</ul>
						</div>
					</li>
					<li className="list-group-item list-release lead">
						<h5>Release 1.10</h5>
						<div className="fs-6 text-light">
							<ul>
								<li> Suggestion and Feedback Page Added</li>
								<li> Landing Page Added</li>
								<li> Project added to github with Login and Sign Up pages.</li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
		</div>
	);
};

export default ReleaseNotes;
