import React, { useState } from "react";
import "../Form.css";
import { Link, useNavigate } from "react-router-dom";
import Swal from "sweetalert2";

const Form = () => {
	const [username, setUserName] = useState("");
	const [email, setEmail] = useState("");
	const [password, setPassword] = useState("");
	const [birthDate, setBirthDate] = useState(null);
	const navigate = useNavigate();

	const addUser = async (user) => {
		const res = await fetch(`http://localhost:8080/users`, {
			method: "POST",
			headers: { "Content-type": "application/json" },
			body: JSON.stringify(user),
		});

		const jsonMessage = await res.json();
		const jsonObj = JSON.parse(JSON.stringify(jsonMessage));
		const message = jsonObj["message"];
		const isAccountCreated = message === "Account created!";
		if (isAccountCreated) {
			Swal.fire({
				title: "Success!",
				text: message,
				icon: "success",
				confirmButtonText: "Login",
			}).then((result) => {
				if (result.isConfirmed) {
					navigate("/login");
				}
			});
		} else {
			Swal.fire({
				title: "Failure",
				text: message,
				icon: "warning",
				confirmButtonText: "Try Again",
			});
		}
	};

	const signupHandler = (e) => {
		e.preventDefault();
		addUser({ username, email, password, birthDate });
	};

	return (
		<div className="mx-4 my-2">
			<form method="post" onSubmit={signupHandler}>
				<div className="input-group col-lg mt-3 my-md-none">
					<label htmlFor="username" className="input-group-text">
						<i className="bi bi-person"></i>
					</label>
					<input
						id="username"
						type="text"
						className="form-control input-box"
						maxLength="30"
						placeholder="Username (Eg. cooldude_007)"
						autoComplete="off"
						onChange={(e) => setUserName(e.target.value)}
						required
					/>
				</div>
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
				<div className="input-group col-lg mt-3 my-md-none">
					<label htmlFor="userbirth" className="input-group-text">
						<i className="bi bi-balloon-heart"></i>
					</label>
					<input
						id="userbirth"
						type="date"
						className="form-control input-box"
						placeholder="Birth Date (yyyy-mm-dd)"
						autoComplete="off"
						max="2010-01-01"
						onChange={(e) => setBirthDate(e.target.value)}
						required
					/>
				</div>
				<div className="fw-light mt-3">
					Already have an account?&nbsp;
					<Link to="/login" className="link">
						Login Here <i className="bi bi-arrow-bar-right"></i>
					</Link>
				</div>
				<div className="my-4 text-center">
					<input
						type="submit"
						className="btn btn-lg btn-outline-dark"
						id="usersubmit"
						rows="3"
						value={"Sign Up!"}
					/>
				</div>
			</form>
		</div>
	);
};

export default Form;
