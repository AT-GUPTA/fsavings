import React from "react";
import Form from "./Form";
import "./SignupBox.css";

const SignupBox = () => {
	return (
		<div>
			<div className="signup-box container text-bg-light rounded-5">
				<h3 className="text-center pt-2 mt-2 fw-semibold">Sign Up</h3>
				<hr />
				<Form />
			</div>
		</div>
	);
};

export default SignupBox;
