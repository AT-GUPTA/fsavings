import React from "react";
import logo from "../Resources/logo.png";

const HomeHeader = () => {
	return (
		<div>
			<h3 className="text-center pt-3 m-0">
				<div>
					<img src={logo} style={{ height: "50px" }} />
					f$avings
				</div>
			</h3>
		</div>
	);
};

export default HomeHeader;
