import { useState } from 'react';
import { Form1, Form2, Form3 } from "../components/Form";
import Stepper from "../components/Stepper";

export default function profile() {
  const [currentStep, setCurrentStep] = useState(1);
	const stepArray = [
		"About",
		"Information",
		// "Service Offered",
		"Connect your bank",
		"Complete"
	];
  const FormComponentToLoad = [
    Form1, Form2, Form3
  ]
	const handleClick = (clickType) => {
		let newStep = currentStep;
		(clickType == "next") ? newStep++ : newStep--;
		// Check if steps are within the boundary
		if (newStep > 0 && newStep <= stepArray.length) {
			setCurrentStep(newStep)
		}
  }
  return (
     <main className='min-h-screen bg-white p-5'>
          <div className="container horizontal mt-5 mb-12">
            <Stepper
              steps={stepArray}
              currentStepNumber={currentStep}
              FormComponentToLoad={FormComponentToLoad}
            />
          </div>
          <div className="container flex justify-around my-8 ">
            <button onClick={() => handleClick()} className="btn-primary transition duration-300 ease-in-out focus:outline-none focus:shadow-outline bg-blue-700 hover:bg-blue-900 text-white font-normal py-2 px-4 mr-1 rounded"> Previous </button>
            <button onClick={() => handleClick("next")} className="btn-outline-primary transition duration-300 ease-in-out focus:outline-none focus:shadow-outline border border-blue-700 hover:bg-blue-700 text-blue-700 hover:text-white font-normal py-2 px-4 rounded"> Next </button>
          </div>
     </main>
  )
}
