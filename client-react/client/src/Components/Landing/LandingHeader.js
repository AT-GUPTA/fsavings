import React from "react";
import "./Landing.css";

const LandingHeader = () => {
	return (
		<nav className="navbar navbar-expand-lg p-0">
			<div className="container-fluid textg-center p-0">
				<div className="navbar-text fs-2 text-center py-2" href="#">
					Welcome to <i className="bi bi-journal-text text-info"></i> Noted.
				</div>
			</div>
		</nav>
	);
};

export default LandingHeader;
