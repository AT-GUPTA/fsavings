import React from "react";
import "./ReleaseNotes.css";
import Header from "../Header";

const ReleaseNotes = () => {
	return (
		<div>
			<div id="release-background-image"></div>
			<Header />
			<h3 className="px-4 pt-4 fw-semibold">
				Releases <i className="bi bi-bar-chart-steps" style={{ color: "yellow" }}></i>
			</h3>
			<hr />
			<ul className="list-group list-group-flush">
				<li className="list-group-item list-release lead">
					<h5>Release 1.15</h5>
					<div className="fs-6 text-light">
						<ul>
							<li> First final version of application released on GitHub with readme file.</li>
							<li> Landing page updated with notes examples and application details.</li>
						</ul>
					</div>
				</li>
				<li className="list-group-item list-release lead">
					<h5>Release 1.14</h5>
					<div className="fs-6 text-light">
						<ul>
							<li> Removed bugs and errors from notes Home page</li>
							<li> Different functionality added (edit/delete notes) with database.</li>
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
							<li> Login and Sign Up pages completed with user interactions.</li>
							<li> SweetAlert API added for user interaction.</li>
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
	);
};

export default ReleaseNotes;
