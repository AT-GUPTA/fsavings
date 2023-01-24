import React from "react";
import "../Form.css";
import { useState } from "react";
import Swal from "sweetalert2";

const Form = () => {
	const [rating, setRating] = useState(0);
	const [feedback, setFeedback] = useState("");

	const feedbackRequest = async (fb) => {
		await fetch(`http://localhost:8080/feedback`, {
			method: "POST",
			headers: { "Content-type": "application/json" },
			body: JSON.stringify(fb),
		});

		Swal.fire({
			title: "Submitted!",
			text: "Your feedback is added.",
			icon: "success",
			confirmButtonText: "Okay!",
		}).then((result) => {
			if (result.isConfirmed) {
				document.getElementById("feedbackForm").reset();
			}
		});
	};

	const feedbackHandler = (e) => {
		e.preventDefault();
		const date = new Date();
		feedbackRequest({ rating, feedback, date });
	};

	return (
		<div className="mx-4 my-2">
			<form method="post" id="feedbackForm" onSubmit={feedbackHandler}>
				<div className="input-group col-lg mt-3 my-md-none">
					<label htmlFor="review-range" className="form-label lead">
						Overall Imperssion: {rating}/100
					</label>
					<input
						type="range"
						className="form-range"
						id="review-range"
						onChange={(e) => setRating(e.target.value)}
					/>
				</div>
				<div className="input-group col-lg mt-3 my-md-none">
					<div className="form-floating">
						<textarea
							className="form-control"
							placeholder="Leave a comment here"
							id="comments"
							onChange={(e) => setFeedback(e.target.value)}
						></textarea>
						<label htmlFor="floatingTextarea2" className="lead fs-6">
							Comments:
						</label>
					</div>
				</div>

				<div className="my-4 text-center">
					<button type="submit" className="btn btn-lg btn-outline-dark" id="usersubmit" rows="3">
						Submit!
					</button>
				</div>
			</form>
		</div>
	);
};

export default Form;
