import React, { useState } from "react";
import "../Form.css";
import { Link, useNavigate } from "react-router-dom";
import Swal from "sweetalert2";

const Form = ({ authentication }) => {
	const [email, setEmail] = useState("");
	const [password, setPassword] = useState("");
	const navigate = useNavigate();

	const loginVerification = async (user) => {
		const res = await fetch(`http://localhost:8080/user/login`, {
			method: "POST",
			headers: { "Content-type": "application/json" },
			body: JSON.stringify(user),
		});

		const jsonMessage = await res.json();
		const jsonObj = JSON.parse(JSON.stringify(jsonMessage));
		const message = jsonObj["message"];
		const isLoggedIn = message !== "";
		if (isLoggedIn) {
			authentication(true);
			Swal.fire({
				title: "Login Success!",
				text: "Hello " + message,
				icon: "success",
				confirmButtonText: "Write Notes!",
			}).then((result) => {
				localStorage.setItem("username", JSON.stringify(message));
				if (result.isConfirmed) {
					navigate("/home");
				}
			});
		} else {
			Swal.fire({
				title: "Login Failure",
				text: "Invalid email or password",
				icon: "warning",
				confirmButtonText: "Try Again",
			});
		}
	};

	const loginHandler = (e) => {
		e.preventDefault();
		loginVerification({ email, password });
	};

	return (
		<div className="mx-4 my-2">
			<form method="post" onSubmit={loginHandler}>
				<div className="input-group col-lg mt-3 my-md-none">
					<label htmlFor="useremail" className="input-group-text">
						<i className="bi bi-envelope"></i>
					</label>
					<input
						id="useremail"
						type="email"
						className="form-control input-box"
						maxLength="40"
						placeholder="Email Address"
						autoComplete="off"
						onChange={(e) => setEmail(e.target.value)}
						required
					/>
				</div>
				<div className="input-group col-lg mt-3 my-md-none">
					<label htmlFor="userpass" className="input-group-text">
						<i className="bi bi-key"></i>
					</label>
					<input
						id="userpass"
						type="password"
						className="form-control input-box"
						maxLength="16"
						minLength="8"
						placeholder="••••••••"
						autoComplete="off"
						onChange={(e) => setPassword(e.target.value)}
						required
					/>
				</div>
				<div className="fw-light mt-3">
					Don't have an account?&nbsp;
					<Link to="/signup" className="link">
						Sign Up! <i className="bi bi-arrow-bar-right"></i>
					</Link>
				</div>
				<div className="my-4 text-center">
					<input
						type="submit"
						className="btn btn-lg btn-outline-dark"
						id="usersubmit"
						rows="3"
						value={"Login!"}
					/>
				</div>
			</form>
		</div>
	);
};

export default Form;
