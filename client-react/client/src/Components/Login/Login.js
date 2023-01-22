import React from "react";
import LoginBox from "./LoginBox";
import "./Login.css";

const Login = ({ authentication }) => {
	return (
		<div>
			<div id="background-image"></div>
			<LoginBox authentication={authentication} />
		</div>
	);
};

export default Login;
