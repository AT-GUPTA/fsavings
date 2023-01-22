import React from "react";
import Header from "../Header";

const Credits = () => {
	return (
		<div>
			<div id="release-background-image"></div>
			<Header />
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
							href="https://unsplash.com/@tamara_photography?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText"
							className="link link-color-white"
						>
							Tamara Gak
						</a>{" "}
						on{" "}
						<a
							href="https://unsplash.com/photos/IBXcdiq-o0A?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText"
							className="link link-color-white"
						>
							Unsplash
						</a>
					</div>
					<div className="fs-6 text-light">
						- Photo by{" "}
						<a
							href="https://unsplash.com/@anniespratt?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText"
							className="link link-color-white"
						>
							Annie Spratt
						</a>{" "}
						on{" "}
						<a
							href="https://unsplash.com/photos/5cFwQ-WMcJU?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText"
							className="link link-color-white"
						>
							Unsplash
						</a>
					</div>
					<div className="fs-6 text-light">
						- Photo by{" "}
						<a
							href="https://unsplash.com/es/@alessia_cocconi?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText"
							className="link link-color-white"
						>
							Alessia Cocconi
						</a>{" "}
						on{" "}
						<a
							href="https://unsplash.com/photos/zLIUdGeKxv0?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText"
							className="link link-color-white"
						>
							Unsplash
						</a>
					</div>
					<div className="fs-6 text-light">
						- Photo by{" "}
						<a
							href="https://unsplash.com/@timothyeberly?utm_source=unsplash&utm_medium=referral&utm_content=creditCopyText"
							className="link link-color-white"
						>
							Timothy Eberly
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
	);
};

export default Credits;
