import React from "react";
import { Link } from "react-router-dom";
import "./Form.css";

const Header = () => {
	return (
		<div>
			<h3 className="text-center pt-3 m-0">
				<Link to="/" className="header">
					<i className="bi bi-journal-text text-info"></i> Noted.
				</Link>
			</h3>
		</div>
	);
};

export default Header;
