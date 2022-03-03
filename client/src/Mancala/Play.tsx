import React from "react";
import type { GameState } from "../gameState";
import "./Play.css";

type PlayProps = {
    gameState: GameState;
    setGameState(newGameState: GameState): void;
};

export function Play ({gameState, setGameState}: PlayProps){
    async function MoveMancala(index:number){
        if (gameState.gameStatus.endOfGame) return;
    
        try{
            const response = await fetch("mancala/api/play", {
                method: "POST",
                headers: {
                    Accept: "application.json",
                    "Content-Type": "application/json"
                },
                body:JSON.stringify({ index: index})
            });
            if (response.ok){
                const gameState = await response.json();
                setGameState(gameState);
            } else {
                console.error(response.statusText);
            }
        } catch (error){
            console.error(error);
        }
    }

function ButtonClicked(index:number) {
    alert('You Selected Cup: ' + (index+1) );
    }    

//Defining variables for React.
const playerOne = gameState.players[0];
const playerTwo = gameState.players[1];

const kalahaOne = playerOne.pits[6];
const kalahaTwo = playerTwo.pits[6];

const cupOne = playerOne.pits[0];
const cupTwo = playerOne.pits[1];
const cupThree = playerOne.pits[2];
const cupFour = playerOne.pits[3];
const cupFive = playerOne.pits[4];
const cupSix = playerOne.pits[5];

const cupEight = playerTwo.pits[0];
const cupNine = playerTwo.pits[1];
const cupTen = playerTwo.pits[2];
const cupEleven = playerTwo.pits[3];
const cupTwelve = playerTwo.pits[4];
const cupThirteen = playerTwo.pits[5];

//Defining the layout of the board.
    return (
        <div className = "Page"> 

            <div className = "Title">Player 1 VS Player 2</div>

            <div className = "Board">

                <div className = "TopBoard">
                    <div className = "KalahaTwo">Kalaha 2 stones:{kalahaTwo.nrOfStones}</div>
                    
                    <button className = "CupsTwo" onClick = {() => ButtonClicked(cupThirteen.index)}>cup 13 stones:{cupThirteen.nrOfStones}</button>
                    <button className = "CupsTwo" onClick = {() => ButtonClicked(cupTwelve.index)}>cup 12 stones:{cupTwelve.nrOfStones}</button>
                    <button className = "CupsTwo" onClick = {() => ButtonClicked(cupEleven.index)}>cup 11 stones:{cupEleven.nrOfStones}</button>
                    <button className = "CupsTwo" onClick = {() => ButtonClicked(cupTen.index)}>cup 10 stones:{cupTen.nrOfStones}</button>
                    <button className = "CupsTwo" onClick = {() => ButtonClicked(cupNine.index)}>cup 9 stones:{cupNine.nrOfStones}</button>
                    <button className = "CupsTwo" onClick = {() => ButtonClicked(cupEight.index)}>cup 8 stones:{cupEight.nrOfStones}</button>
                    <button className = "Filler">Player 2</button>
                </div>

                <div className = "BottomBoard">
                    <button className = "Filler">Player 1</button>
                    <button className = "CupsOne" onClick = {() => ButtonClicked(cupOne.index)}>cup 1 stones:{cupOne.nrOfStones}</button>
                    <button className = "CupsOne" onClick = {() => ButtonClicked(cupTwo.index)}>cup 2 stones:{cupTwo.nrOfStones}</button>
                    <button className = "CupsOne" onClick = {() => ButtonClicked(cupThree.index)}>cup 3 stones:{cupThree.nrOfStones}</button>
                    <button className = "CupsOne" onClick = {() => ButtonClicked(cupFour.index)}>cup 4 stones:{cupFour.nrOfStones}</button>
                    <button className = "CupsOne" onClick = {() => ButtonClicked(cupFive.index)}>cup 5 stones:{cupFive.nrOfStones}</button>
                    <button className = "CupsOne" onClick = {() => ButtonClicked(cupSix.index)}>cup 6 stones:{cupSix.nrOfStones}</button>
                    
                    <div className = "KalahaOne">Kalaha 1 stones:{kalahaOne.nrOfStones}</div>
                </div>
            </div> 
        </div>
    )
}