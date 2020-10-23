import React from "react";
import { render } from "@testing-library/react";
import App from "./App";

jest.mock("./ScoreDisplay");

describe("App Component", () => {
    test("renders the app component", () => {
        const { getByText, getAllByText } = render(<App />);
        expect(getByText(/Scoreboard/i)).toBeInTheDocument();
    });
});
