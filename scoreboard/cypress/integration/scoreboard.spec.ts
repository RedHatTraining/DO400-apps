beforeEach(() => {
    // GIVEN the user is on the app
    cy.visit("/");
});

describe("add player", () => {
    it("should add a player", () => {
        // AND the user has entered 'bobby' into the 'Player Name' field
        cy.get("form").find('[placeholder="Player Name"]').type("bobby");

        // WHEN they submit the form
        cy.get("form").submit();

        // THEN 'bobby' should be added to the players
        cy.get("#player-scores").should("contain", "bobby");
    });
});

describe("update score", () => {
    beforeEach(() => {
        // AND the player 'tom' exists
        cy.get("form").find('[placeholder="Player Name"]').type("tom");
        cy.get("form").submit();
    });

    it("should increase a player's score", () => {
        // AND tom has a score of 0
        cy.get("#player-scores").should("contain", "tom: 0");

        // WHEN the user hits '+' next to 'tom'
        cy.get("#player-scores")
            .contains("tom")
            .siblings()
            .contains("+")
            .click();

        // THEN 'tom's score should be 1
        cy.get("#player-scores").should("contain", "tom: 1");
    });

    it("should decrease a player's score", () => {
        // AND tom has a score of 0
        cy.get("#player-scores").should("contain", "tom: 0");

        // WHEN the user hits '-' next to 'tom'
        cy.get("#player-scores")
            .contains("tom")
            .siblings()
            .contains("-")
            .click();

        // THEN 'tom's score should be -1
        cy.get("#player-scores").should("contain", "tom: -1");
    });
});
