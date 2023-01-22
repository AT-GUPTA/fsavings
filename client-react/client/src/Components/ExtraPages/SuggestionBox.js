import React from "react";
import Header from "../Header";
import Form from "./Form";
import "./Suggestions.css";

const SuggestionBox = () => {
	return (
		<div>
			<Header />
			<div className="suggestion-box container text-bg-light rounded-5">
				<h3 className="text-center pt-2 mt-2 fw-semibold">Feedback & Suggestions!</h3>
				<hr />
				<Form />
			</div>
		</div>
	);
};

export default SuggestionBox;
