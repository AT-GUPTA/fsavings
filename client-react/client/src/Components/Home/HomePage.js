import React, { useState, useEffect } from "react";
import HomeHeader from "../HomeHeader";
import "./HomePage.css";
import { useNavigate } from "react-router-dom";
import Swal from "sweetalert2";

const modifyNoteContent = (jsonObj) => {
	for (var i = 0; i < jsonObj.length; i++) {
		jsonObj[i].note = jsonObj[i].note.replace(/(^"|"$)/g, "");
		jsonObj[i].date = jsonObj[i].date.substring(0, 10);
	}
	return jsonObj;
};

const HomePage = () => {
	var username = JSON.parse(localStorage.getItem("username"));
	const navigate = useNavigate();
	const logOutHandler = () => {
		localStorage.clear();
		navigate("/");
	};

	const [newNote, setnewNote] = useState("");
	const [notes, setNotes] = useState([]);

	useEffect(() => {
		fetchNotesData(username).then((data) => setNotes(data));
	}, [username]);

	const fetchNotesData = async (username) => {
		const res = await fetch(`http://localhost:8080/note/` + username, {
			method: "POST",
			headers: { "Content-type": "application/json" },
		});
		const jsonMessage = await res.json();
		const jsonObj = JSON.parse(JSON.stringify(jsonMessage));
		modifyNoteContent(jsonObj);
		return jsonObj;
	};

	const addNote = async (note) => {
		const res = await fetch(`http://localhost:8080/note`, {
			method: "POST",
			headers: { "Content-type": "application/json" },
			body: JSON.stringify(note),
		});
		const jsonMessage = await res.json();
		const jsonObj = JSON.parse(JSON.stringify(jsonMessage));
		modifyNoteContent(jsonObj);
		setNotes(jsonObj);
		setnewNote("");
	};

	const addNoteHandler = (e) => {
		e.preventDefault();
		const date = new Date();
		const note = JSON.stringify(newNote);
		addNote({ username, note, date });
	};

	const editNoteHandler = async (editNote) => {
		const res = await fetch("http://localhost:8080/notes/" + editNote.id, { method: "DELETE" });
		const jsonMessage = await res.json();
		const jsonObj = JSON.parse(JSON.stringify(jsonMessage));
		modifyNoteContent(jsonObj);
		setNotes(jsonObj);
		setnewNote(editNote.note);
	};

	const deleteNoteHandler = (id) => {
		Swal.fire({
			title: "Confirm!?",
			text: "The given note will be deleted.",
			icon: "question",
			confirmButtonText: "Delete!",
			cancelButtonText: "Cancel",
			showCancelButton: true,
		}).then(async (result) => {
			if (result.isConfirmed) {
				const res = await fetch("http://localhost:8080/notes/" + id, { method: "DELETE" });
				const jsonMessage = await res.json();
				const jsonObj = JSON.parse(JSON.stringify(jsonMessage));
				modifyNoteContent(jsonObj);
				setNotes(jsonObj);
				setnewNote("");
			}
		});
	};

	return (
		<div>
			<div id="home-background-image"></div>
			<HomeHeader />
			<div className="d-flex justify-content-between">
				<h3 className="fw-semibold mx-4 mt-4">Welcome {username}!</h3>
				<button className="btn btn-outline-light mx-4 mt-4" onClick={logOutHandler}>
					Logout <i className="bi bi-box-arrow-right"></i>
				</button>
			</div>
			<hr />
			<div className="row m-0 note-window">
				<div className="col-5 border-right"></div>
				<div className="col-7">
					<div className="row m-0"></div>
				</div>
			</div>
		</div>
	);
};

export default HomePage;
