# MCR 2019 - Command Pattern

> Nohan BUDRY,  Alexandre MARQUES, Andrés MORENO, Didier PAGE, Robel TEKLEHAIMANOT

## Introduction

For the class MCR at HEIG-VD, we were given a programming pattern, the command pattern, and asked to create a preject that uses it. The project has to be interesting and must show how to use the command pattern.

## Concept

This project is a one versus one combat and stategy game. Each player has a set of actions to move, attack, defend or use spells. They fight on a linear map composed of tiles. Each player can chose the actions they want to play and the fight is simulated by executing them.

For example, during a round, players chose 10 actions each. During the simulation, two actions for the first player will be executed and then two for the second player until there are no more actions (this is only an example and may change).

### Actions

The command pattern is used to represent the actions. For example, an attack may be a simple command that deals dammage to a player and a more complex one may deal damage and also poison the target or heal the caster. This shows the use of a macro command which is a composit of simple commands to create a more complex one (uses the composit pattern).

Each action costs some kind of points like mana or energy, so that the player needs to think of a strategy and use his points wisely.

#### Types

- Movement: Moves a character $x$ number of tiles forward or backward.
- Attack: Deals damage at a range and within an area of effect.
- Defense: Prevents the player from taking damage.
- Boosts: Adds positive or negative bonuses to stats.
- Spells: Represents complex actions like canceling the last action, placing zone with some effect when stepped on or even compositions of attacks, movements, defenses, boosts and spells.

### Characters

A character is played by players or AI and has differents stats like health or base damage.

#### Stats

- Health: Represents the number of life points. If it reaches zero, the character dies.
- Damage: The base attack damage of a character. Used when calculating damage.
- Defense: The base defense of a character. Reduces the incoming damage.
- Energy: The max number of action points a player can use to execute actions.

#### Classes

A class is a specification for a character. Represents the fighting style of a character. Each class has a different set of action and base stats.

- **Fighter**: Deals heavy damage in close combat and boosts himself.

- **Mage**: Specializes in ranged attacks and healing.

- **PDO**: Has great dodging skills and sneak attacks. Do not forget about his lightsaber, or danger awaits!