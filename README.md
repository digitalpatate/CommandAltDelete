# MCR 2019 - Command Pattern

> Nohan BUDRY,  Alexandre MARQUES, Andrés MORENO, Didier PAGE, Robel TEKLEHAIMANOT

## Introduction

For the class MCR at HEIG-VD, we were given a programming pattern, the command pattern, and asked to create a project that uses it. The project has to be interesting and must show how to use the command pattern..

## Concept

This project is a one versus one combat and stategy game. Each player has a set of actions to move, attack, defend or use spells. They fight on a linear map composed of tiles. Each player can chose the actions they want to play and the fight is simulated by executing them.

### Map

The map is represented as a finite line of tiles.

There are two characters on the map facing each others. They can move forward or backward (always facing the opponent) and they can't pass through each other.

An attack will always be launched in front of the character. Attacks don't have any range, so it will affect every tiles until the end of the map. The damages may vary depending of the distance.

### Actions

The command pattern is used to represent the actions. For example, an attack may be a simple command that deals dammage to a player and a more complex one may deal damage and also poison the entity or heal the caster. This shows the use of a macro command which is a composit of simple commands to create a more complex one (uses the composit pattern).

Each action costs energy and have priority, so that the player needs to carefully use his points and order his actions.

#### Movement

Moves a character x tiles forward or backward relatively of where it's facing. Characters can't pass through each other.

#### Attack

Deals damage to everything in front of the player. Damages are calculated with a percentage of the character's damage stat. The entity's health point can't go lower than zero. This pourcentage varies with distance. For exemple: 120% in the first 3 tiles, 80% in the next 5 and 40% until the end of the map.

#### Heal

Heals the caster with a specific amount of health point. The character's life can't go higher than a max value.

#### Status Effect

Heals or deals damage to a characters with a fixed value (ignores defense) during a fixed period of time. Takes effect every time the character uses an action and. The remaining duration is reduced when it takes effect and the status effect is removed when the duration reaches zero.

#### Boost

Adds positive or negative bonuses to the attack and the defense stats. As for the status effect, there is a duration and the boost disapears whent it reaches zero. For attack boosts, the duration is reduced during each attack the character casts. For he defense boosts, the duration is reduced every time the character gets hit by an attack (only attacks and not status effects).

#### Spells

A spell represents a complex action. It can be any composition of the previous actions. It can also be any unique action that doesnt enter in the categories above. For exemple it may cancel an opponent's action or push the opponent backward.

### Characters

A character is played by players or AI and has different stats like health or base damage.

#### Stats

- Health: Represents the number of life points. If it reaches zero, the character dies, Has a max value
- Damage: The base attack damage.
- Defense: The base defense.
- Energy: The max number of action points a player can use each turn.

#### Classes

A class is a specification for a character. Represents the fighting style of a character. Each class has a different set of actions and stats values.

#### Examples

- **Fighter**: Deals heavy damage in close combat and boosts himself.

- **Mage**: Specializes in ranged attacks and healing.


### Game

Two characters fight on a map. The game ends when one of the characters dies.

#### Round

Each round the players can spend their energy to form a list of actions they which to play. They can't see what his opponent will use. And they can chose the order of their actions. When the lists are ready, the round simulation starts.

#### Simulation

During the simulation, actions are executed one after another. The order of execution is calculated  with the priorities of the actions. 