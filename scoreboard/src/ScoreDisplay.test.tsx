import React from "react";
import { fireEvent, render } from "@testing-library/react";
import { ScoreDisplay } from "./ScoreDisplay";

describe("ScoreDisplay Component", () => {
    test("renders a player's score", () => {
        const { getByText } = render(
            <ScoreDisplay name="foo" score={3} onUpdateScore={() => {}} />,
        );
        expect(getByText(/foo: 3/i)).toBeInTheDocument();
    });

    test("calls update score on + and -", () => {
        const updateScoreMock = jest.fn();
        const { getByText } = render(
            <ScoreDisplay
                name="foo"
                score={3}
                onUpdateScore={updateScoreMock}
            />,
        );
        fireEvent.click(getByText(/\+/));
        fireEvent.click(getByText(/\-/));
        expect(updateScoreMock).toBeCalledTimes(2);
    });
});
