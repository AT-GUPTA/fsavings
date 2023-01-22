import React from "react";
import LandingHeader from "./LandingHeader";
import "./Landing.css";
import { Link } from "react-router-dom";
import example1 from "../../Resources/example1.png";
import example2 from "../../Resources/example2.png";
import example3 from "../../Resources/example3.png";

const Landing = () => {
	const getLink = () => {
		const url = "http://localhost:3000/";
		navigator.clipboard.writeText(url);
		alert("Noted - link copied to clipboard.");
	};

	return (
		<div>
			<LandingHeader />
			<div id="landing-background-image"></div>
			<div className="row m-0 p-0">
				{/* left-body */}
				<div className="col">
					<div className="row card m-3">
						<div className="card-body text-dark">
							<h3 className="card-title head">Create An Account Today!</h3>
							<h6 className="card-subtitle mb-2 text-muted">Start writing notes</h6>
							<p className="card-text fs-5">
								By creating an account, you will be able to write notes and store it on our database
								anonymously. You only require an email id to sign up and get started. Already have
								an account? Login!
							</p>
							<Link to="/signup" className="link">
								Sign Up
							</Link>
							{" | "}
							<Link to="/login" className="link">
								Login
							</Link>
						</div>
					</div>
					<div className="row card m-3">
						<div className="card-body text-dark">
							<h3 className="card-title head">Know The Creator!</h3>
							<h6 className="card-subtitle mb-2 text-muted">- Bhavya Ruparelia</h6>
							<p className="card-text fs-5">
								Hey! I am a 21-year-old Java developer and AI enthusiast. Want to work with me?
								Connect with me on LinkedIn&nbsp;
								<a href="https://www.linkedin.com/in/bhavya-ruparelia/" id="linked-in">
									<i className="bi bi-linkedin"></i>
								</a>
								. Know more about me by following the given link!
							</p>
							<a href="https://bhavyaruparelia.me/" className="link">
								Reach Out <i className="bi bi-person"></i>
							</a>
						</div>
					</div>
					<div className="row card m-3">
						<div className="card-body text-dark">
							<h3 className="card-title head">Suggestion Box!</h3>
							<h6 className="card-subtitle mb-2 text-muted">
								Send your suggestions to make 'Noted' better
							</h6>
							<p className="card-text fs-5">
								Your feedback matters! Write few words about your experience. Add suggestions for
								the future updates.
							</p>
							<Link to="/suggestions" className="link">
								Suggestions & Feedback <i className="bi bi-pencil-square"></i>
							</Link>
						</div>
					</div>
				</div>

				{/* main-body */}
				<div className="col-6 m-0">
					<div className="row card m-3">
						<div className="card-body text-dark">
							<h3 className="card-title ">How to use Noted!?</h3>
							<h6 className="card-subtitle mb-2 text-muted">Here are some examples...</h6>
							<div>
								<div className="row lead mb-4 mx-2">
									Are you tired of cluttered notebooks and lost sticky notes? This web application
									is here to help! Main purpose of this application is to store notes for users,
									allowing them to create, save, and organize written notes and information in a
									digital format. This can be helpful for keeping track of important information,
									making lists, and jotting down ideas. Below are few images of the same.
								</div>
								<div className="row mb-4">
									<div
										id="carouselExampleIndicators"
										className="carousel slide"
										data-bs-ride="true"
									>
										<div className="carousel-indicators">
											<button
												type="button"
												data-bs-target="#carouselExampleIndicators"
												data-bs-slide-to="0"
												className="active"
												aria-current="true"
												aria-label="Slide 1"
											></button>
											<button
												type="button"
												data-bs-target="#carouselExampleIndicators"
												data-bs-slide-to="1"
												aria-label="Slide 2"
											></button>
											<button
												type="button"
												data-bs-target="#carouselExampleIndicators"
												data-bs-slide-to="2"
												aria-label="Slide 3"
											></button>
										</div>
										<div className="carousel-inner">
											<div className="carousel-item active">
												<img src={example1} className="d-block w-100" alt="Example 1" />
											</div>
											<div className="carousel-item">
												<img src={example2} className="d-block w-100" alt="Example 2" />
											</div>
											<div className="carousel-item">
												<img src={example3} className="d-block w-100" alt="Example 3" />
											</div>
										</div>
										<button
											className="carousel-control-prev"
											type="button"
											data-bs-target="#carouselExampleIndicators"
											data-bs-slide="prev"
										>
											<span className="carousel-control-prev-icon" aria-hidden="true"></span>
											<span className="visually-hidden">Previous</span>
										</button>
										<button
											className="carousel-control-next"
											type="button"
											data-bs-target="#carouselExampleIndicators"
											data-bs-slide="next"
										>
											<span className="carousel-control-next-icon" aria-hidden="true"></span>
											<span className="visually-hidden">Next</span>
										</button>
									</div>
								</div>
								<div className="row lead mb-4 mx-2">
									Users can typically access their notes from any device with an internet connection
									and can share their notes with others as needed. The application offers basic
									formatting options, such as the ability to bold or italicize text, create bulleted
									or numbered lists, and add hyperlinks.
								</div>
							</div>
						</div>
					</div>
				</div>

				{/* right-body */}
				<div className="col m-0">
					<div className="row card m-3">
						<div className="card-body text-dark">
							<h3 className="card-title head-2">Release Notes!</h3>
							<h6 className="card-subtitle mb-2 text-muted">Check the updates </h6>
							<p className="card-text fs-5">
								By creating an account, you will be able to write notes which will be shown
								anonymously to other people. While you will be able to see what others write.
							</p>
							<Link to="/release-notes" className="link">
								Release Notes <i className="bi bi-bar-chart-line"></i>
							</Link>
						</div>
					</div>
					<div className="row card m-3">
						<div className="card-body text-dark">
							<h3 className="card-title head-2">Credits To The Helpers!</h3>
							<h6 className="card-subtitle mb-2 text-muted">
								A special thanks to people contributing to 'Noted'
							</h6>
							<p className="card-text fs-5">
								This web application may not be the same without the help of several individuals
								helping by providing free to use content for this web application.
							</p>
							<Link to="/credits" className="link">
								Rights & Credits <i className="bi bi-arrow-bar-right"></i>
							</Link>
						</div>
					</div>
					<div className="row card m-3">
						<div className="card-body text-dark">
							<h3 className="card-title head-2">Website Reach!</h3>
							<h6 className="card-subtitle mb-2 text-muted">Total number of account creations</h6>
							<p className="card-text fs-5">
								I am confident that every user of 'Noted' enjoys this space and so would you. Keep
								showing your love to this web application. Share it with your family and friends!
							</p>
							<button className="btn-link link" onClick={getLink}>
								Noted <i className="bi bi-link-45deg"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	);
};

export default Landing;
