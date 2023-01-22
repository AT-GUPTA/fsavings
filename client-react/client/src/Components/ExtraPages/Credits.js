import React from "react";
import { Link } from "react-router-dom";

const Credits = () => {
	return (
		<div>
			<nav class="navbar navbar-expand-lg bg-light">
				<div class="container-fluid">
					<span className="text-decoration-none fw-bold h4 m-0 p-0" id="company-name">f$AVINGS</span>
					<button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
					data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
					aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<Link to="/login" className="nav-item nav-link mx-3 link">
								Login <i class="bi bi-box-arrow-in-right"></i>
							</Link>
							<Link to="/suggestions" className="nav-item nav-link mx-3 link">
								Suggestions <i className="bi bi-pencil-square"></i>
							</Link>
							<Link to="/release-notes" className="nav-item nav-link mx-3 link">
								Release Notes <i className="bi bi-bar-chart-line"></i>
							</Link>
							<Link to="/credits" className="nav-item nav-link mx-3 link">
								Credits <i className="bi bi-arrow-bar-right"></i>
							</Link>
						</ul>
					</div>
				</div>	
			</nav>
			<div>
				<div id="release-background-image"></div>
				<h3 className="px-4 pt-4 fw-semibold">
					Credits <i className="bi bi-person-vcard" style={{ color: "yellow" }}></i>
				</h3>
				<hr />
				<ul className="list-group list-group-flush">
					<li className="list-group-item list-release lead mt-1">
						<h5>Frameworks</h5>
						<div className="fs-6 text-light">
							-{" Frontend services by "}
							<a href="https://reactjs.org/" className="link link-color-white">
								ReactJS
							</a>
						</div>
						<div className="fs-6 text-light">
							-{" Backend REST services by "}
							<a href="https://spring.io/projects/spring-boot" className="link link-color-white">
								SpringBoot
							</a>
						</div>
					</li>
					<li className="list-group-item list-release lead mt-1">
						<h5>Libraries & APIs</h5>
						<div className="fs-6 text-light">
							-{" CSS Styling by "}
							<a href="https://getbootstrap.com/" className="link link-color-white">
								Bootstrap
							</a>
						</div>
						<div className="fs-6 text-light">
							-{" Textarea editor by "}
							<a href="https://quilljs.com/" className="link link-color-white">
								Quill
							</a>
						</div>
						<div className="fs-6 text-light">
							-{" Alert theme by "}
							<a href="https://sweetalert2.github.io/" className="link link-color-white">
								SweetAlert2
							</a>
						</div>
					</li>
					<li className="list-group-item list-release lead mt-1">
						<h5>Images</h5>
						<div className="fs-6 text-light">
							- Photo by{" "}
							<a
								href="https://unsplash.com/@timothyeberly?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText"
								className="link link-color-white"
							>
								Change this
							</a>{" "}
							on{" "}
							<a
								href="https://unsplash.com/photos/U4UwzRSns6M?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText"
								className="link link-color-white"
							>
								Unsplash
							</a>
						</div>
					</li>
				</ul>
			</div>
		</div>
	);
};

export default Credits;
