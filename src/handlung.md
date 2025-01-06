/**
* Players have three basic stats, attack, health and defense, with the default starting at 5.

All coefficients/stats are rounded, not decimals

damage sustained = (enemy attack index) / ((own defense index + 100) / 100)

Entering the game, players can choose one of four development directions:
1. Water Element: become a healer, can restore 20% of health to a team member every 5 turns (can choose to heal or continue attacking)
2. Earth Element: become a tank, has an 8% chance of not taking damage in a turn
3. Fire Element: become a swordsman, has an 18% chance of having critical damage (critical damage = basic attack index * (random number from 150% to 250%).
4. Air Element: has an 20% chance of having one more turn

The game also has the Elemental Resonance panel, they can be used when our team has members with that element, they also have the same effect on enemies.

1. Water + Earth: add 20% health to all members after completing each round (all teammates/opponents have completed 1 turn)
2. Water + Fire: Deal critical damage to the opponent with the most health after completing each round
3. Water + Air: increase 30% defense of all teammates for the entire game
4. Fire + Earth: reduce 20% health for all enemies after completing each round
5. Fire + Air: reduce 30% defense of all enemies for the entire game
6. Earth + Air: Each round, 10% of all enemies cannot attack all members in the team

After choosing the element, each attack, health, defense index is 5,5,5. Players have 2 chances to increase the desired stat coefficient.

Start

Chapter 1:
Game 1: You attack 2 wolves (attack, health, defense index is 1,5,0 with Fire Element).
If you win, you receive the Fire Element stone from them, if you lose, play again from chapter 1.
After picking it up, there is a guy named Duke who wants to get it back from you so that he can collect all the stones. Because you both have the same goal, you decide to cooperate to collect all 4 stones.
Game 2: After cooperating, you are attacked by 3 wolves. Duke (attack, health, defense index is 10,10,10 respectively) attacks 3 wolves with you. If you win, you have 1 chance to increase the desired stat coefficient for yourself. If you lose, start again from chapter 1.

Chapter 2:
Game 1: You attack 3 witches with 3 elements Water, Fire, Air with index 7,15,7)
If you win, you rescue Charlotte, who holds the Water element stone and you get to increase your desired index coefficient by 1 time.

Chapter 3:
The three of you are on the way to find the boss holding the remaining stones: While walking, tell stories about each person's background (can be used as a minigame)

Chapter 4:
Meet the boss (Air, Water, Fire, Earth elements with index 7,30,15). If you win, you get all the stones.
*/