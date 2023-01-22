import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import "./App.css";
import Signup from "./Components/SignUp/Signup";
import Login from "./Components/Login/Login";
import Landing from "./Components/Landing/Landing";
import Suggestions from "./Components/ExtraPages/Suggestions";
import ReleaseNotes from "./Components/ExtraPages/ReleaseNotes";
import Credits from "./Components/ExtraPages/Credits";
import HomePage from "./Components/Home/HomePage";
import { useState } from "react";

function App() {
	const [isAuth, setIsAuth] = useState(() => {
		const saved = localStorage.getItem("isAuth");
		const initialValue = JSON.parse(saved);
		return initialValue || false;
	});
	const allowAuth = async (doAllow) => {
		setIsAuth(doAllow);
		localStorage.setItem("isAuth", JSON.stringify(doAllow));
	};
	return (
		<div>
			<BrowserRouter>
				<Routes>
					<Route exact path="/" element={<Landing />} />
					<Route exact path="/signup" element={<Signup />} />
					<Route exact path="/login" element={<Login authentication={allowAuth} />} />
					<Route exact path="/suggestions" element={<Suggestions />} />
					<Route exact path="/release-notes" element={<ReleaseNotes />} />
					<Route exact path="/credits" element={<Credits />} />
					<Route exact path="/home" element={isAuth ? <HomePage /> : <Navigate to="/Login" />} />
				</Routes>
			</BrowserRouter>
		</div>
	);
}

export default App;
