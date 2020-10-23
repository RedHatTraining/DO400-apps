import React, { useState } from "react";

import { Player } from "./Player";
import { ScoreDisplay } from "./ScoreDisplay";

function App() {
    const [playerName, setPlayerName] = useState<string>("");
    const [players, setPlayers] = useState<Player[]>([]);

    function updateScore(playerName: string, newScore: number) {
        const updatedPlayers = players.map((player) => {
            if (player.name === playerName) {
                return { ...player, score: newScore };
            } else {
                return player;
            }
        });
        setPlayers(updatedPlayers);
    }

    function newPlayerSubmit(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();
        setPlayers([...players, { name: playerName, score: 0 }]);
    }

    return (
        <>
            <h1>Scoreboard</h1>

            <div id="player-scores">
                {players.map((player, index) => (
                    <ScoreDisplay
                        key={index}
                        name={player.name}
                        score={player.score}
                        onUpdateScore={updateScore}
                    />
                ))}
            </div>

            <br />

            <form onSubmit={newPlayerSubmit}>
                <input
                    type="text"
                    placeholder="Player Name"
                    value={playerName}
                    maxLength={10}
                    onChange={(e) => setPlayerName(e.currentTarget.value)}
                />
                <button type="submit">Add Player</button>
            </form>
        </>
    );
}

export default App;
