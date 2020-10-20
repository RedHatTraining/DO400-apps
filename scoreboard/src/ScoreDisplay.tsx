import React from "react";

export function ScoreDisplay(props: {
    name: string;
    score: number;
    onUpdateScore: (name: string, score: number) => void;
}) {
    const { name, score } = props;

    return (
        <div className="score-display">
            <span>
                {name}: {score}
            </span>
            <button
                aria-label={`increase ${name}'s score`}
                type="button"
                onClick={() => props.onUpdateScore(name, score + 1)}
            >
                +
            </button>
            <button
                aria-label={`decrease ${name}'s score`}
                type="button"
                onClick={() => props.onUpdateScore(name, score - 1)}
            >
                -
            </button>
        </div>
    );
}
