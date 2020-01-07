package ca.pokebattle.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.pokebattle.entity.Type;
import ca.pokebattle.repository.TypeRepository;
/**
 * Calculates damage modification
 * @author Ily
 *
 */
@Component
public class DamageModifierModel {


	private static final String NOT_STAB = "was NOT applied.";
	
	private static final String STAB = "was applied!";
	
	private static String DOUBLE_DAMAGE = "double damage";

	private static String HALF_DAMAGE = "half damage";

	private static String NO_DAMAGE = "no damage";

	private static String NORMAL_DAMAGE = "normal damage";

	private static final String NORMAL = "normal";

	private static final String FIGHTING = "fighting";

	private static final String FLYING = "flying";

	private static final String POISON = "poison";

	private static final String GROUND = "ground";

	private static final String ROCK = "rock";

	private static final String BUG = "bug";

	private static final String GHOST = "GHOST";

	private static final String STEEL = "steel";

	private static final String FIRE = "fire";

	private static final String WATER = "water";

	private static final String GRASS = "grass";

	private static final String ELECTRIC = "electric";

	private static final String PSYCHIC = "psychic";

	private static final String ICE = "ice";

	private static final String DRAGON = "dragon";

	private TypeRepository typeRepository;

	@Autowired
	public void setTypeRepository(TypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}
/**
 * Runs algorithm depending on input type
 * @param moveType
 * @param defenderType
 * @return
 */
	public String getDamageModifier(String moveType, String defenderType) {
		switch (moveType) {
		case NORMAL:
			return normalAttack(defenderType);
		case FIGHTING:
			return fightingAttack(defenderType);
		case FLYING:
			return flyingAttack(defenderType);
		case POISON:
			return poisonAttack(defenderType);
		case GROUND:
			return groundAttack(defenderType);
		case ROCK:
			return rockAttack(defenderType);
		case BUG:
			return bugAttack(defenderType);
		case GHOST:
			return ghostAttack(defenderType);
		case FIRE:
			return fireAttack(defenderType);
		case WATER:
			return waterAttack(defenderType);
		case GRASS:
			return grassAttack(defenderType);
		case ELECTRIC:
			return electricAttack(defenderType);
		case PSYCHIC:
			return psychicAttack(defenderType);
		case ICE:
			return iceAttack(defenderType);
		case DRAGON:
			return dragonAttack(defenderType);
		default:
			return NORMAL_DAMAGE;
		}
	}
/**
 * Returns correct STAB application (Same Type Attack Bonus modifier)
 * @param attackerType
 * @param moveType
 * @return
 */
	public String isSTAB(Type attackerType, Type moveType) {
		if (attackerType.equals(moveType))
			return STAB;
		else
			return NOT_STAB;
	}

	private String normalAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NORMAL_DAMAGE;
		case FIGHTING:
			return NORMAL_DAMAGE;
		case FLYING:
			return NORMAL_DAMAGE;
		case POISON:
			return NORMAL_DAMAGE;
		case GROUND:
			return NORMAL_DAMAGE;
		case ROCK:
			return HALF_DAMAGE;
		case BUG:
			return NORMAL_DAMAGE;
		case GHOST:
			return NO_DAMAGE;
		case FIRE:
			return NORMAL_DAMAGE;
		case WATER:
			return NORMAL_DAMAGE;
		case GRASS:
			return NORMAL_DAMAGE;
		case ELECTRIC:
			return NORMAL_DAMAGE;
		case PSYCHIC:
			return NORMAL_DAMAGE;
		case ICE:
			return NORMAL_DAMAGE;
		case DRAGON:
			return NORMAL_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

// ALL GENERATION I TYPE INTERACTIONS


	private String fightingAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return DOUBLE_DAMAGE;
		case FIGHTING:
			return NORMAL_DAMAGE;
		case FLYING:
			return HALF_DAMAGE;
		case POISON:
			return HALF_DAMAGE;
		case GROUND:
			return NORMAL_DAMAGE;
		case ROCK:
			return DOUBLE_DAMAGE;
		case BUG:
			return HALF_DAMAGE;
		case GHOST:
			return NO_DAMAGE;
		case FIRE:
			return NORMAL_DAMAGE;
		case WATER:
			return NORMAL_DAMAGE;
		case GRASS:
			return NORMAL_DAMAGE;
		case ELECTRIC:
			return NORMAL_DAMAGE;
		case PSYCHIC:
			return HALF_DAMAGE;
		case ICE:
			return DOUBLE_DAMAGE;
		case DRAGON:
			return NORMAL_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

	private String flyingAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NORMAL_DAMAGE;
		case FIGHTING:
			return DOUBLE_DAMAGE;
		case FLYING:
			return NORMAL_DAMAGE;
		case POISON:
			return NORMAL_DAMAGE;
		case GROUND:
			return NORMAL_DAMAGE;
		case ROCK:
			return HALF_DAMAGE;
		case BUG:
			return DOUBLE_DAMAGE;
		case GHOST:
			return NORMAL_DAMAGE;
		case FIRE:
			return NORMAL_DAMAGE;
		case WATER:
			return NORMAL_DAMAGE;
		case GRASS:
			return DOUBLE_DAMAGE;
		case ELECTRIC:
			return HALF_DAMAGE;
		case PSYCHIC:
			return NORMAL_DAMAGE;
		case ICE:
			return NORMAL_DAMAGE;
		case DRAGON:
			return NORMAL_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

	private String poisonAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NORMAL_DAMAGE;
		case FIGHTING:
			return NORMAL_DAMAGE;
		case FLYING:
			return NORMAL_DAMAGE;
		case POISON:
			return HALF_DAMAGE;
		case GROUND:
			return HALF_DAMAGE;
		case ROCK:
			return HALF_DAMAGE;
		case BUG:
			return DOUBLE_DAMAGE;
		case GHOST:
			return HALF_DAMAGE;
		case FIRE:
			return NORMAL_DAMAGE;
		case WATER:
			return NORMAL_DAMAGE;
		case GRASS:
			return DOUBLE_DAMAGE;
		case ELECTRIC:
			return NORMAL_DAMAGE;
		case PSYCHIC:
			return NORMAL_DAMAGE;
		case ICE:
			return NORMAL_DAMAGE;
		case DRAGON:
			return NORMAL_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

	private String groundAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NORMAL_DAMAGE;
		case FIGHTING:
			return NORMAL_DAMAGE;
		case FLYING:
			return NO_DAMAGE;
		case POISON:
			return DOUBLE_DAMAGE;
		case GROUND:
			return NORMAL_DAMAGE;
		case ROCK:
			return DOUBLE_DAMAGE;
		case BUG:
			return HALF_DAMAGE;
		case GHOST:
			return NORMAL_DAMAGE;
		case FIRE:
			return DOUBLE_DAMAGE;
		case WATER:
			return NORMAL_DAMAGE;
		case GRASS:
			return HALF_DAMAGE;
		case ELECTRIC:
			return DOUBLE_DAMAGE;
		case PSYCHIC:
			return NORMAL_DAMAGE;
		case ICE:
			return NORMAL_DAMAGE;
		case DRAGON:
			return NORMAL_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

	private String rockAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NORMAL_DAMAGE;
		case FIGHTING:
			return HALF_DAMAGE;
		case FLYING:
			return DOUBLE_DAMAGE;
		case POISON:
			return NORMAL_DAMAGE;
		case GROUND:
			return HALF_DAMAGE;
		case ROCK:
			return NORMAL_DAMAGE;
		case BUG:
			return DOUBLE_DAMAGE;
		case GHOST:
			return NORMAL_DAMAGE;
		case FIRE:
			return DOUBLE_DAMAGE;
		case WATER:
			return NORMAL_DAMAGE;
		case GRASS:
			return NORMAL_DAMAGE;
		case ELECTRIC:
			return NORMAL_DAMAGE;
		case PSYCHIC:
			return NORMAL_DAMAGE;
		case ICE:
			return DOUBLE_DAMAGE;
		case DRAGON:
			return NORMAL_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

	private String bugAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NORMAL_DAMAGE;
		case FIGHTING:
			return HALF_DAMAGE;
		case FLYING:
			return HALF_DAMAGE;
		case POISON:
			return DOUBLE_DAMAGE;
		case GROUND:
			return NORMAL_DAMAGE;
		case ROCK:
			return NORMAL_DAMAGE;
		case BUG:
			return NORMAL_DAMAGE;
		case GHOST:
			return HALF_DAMAGE;
		case FIRE:
			return HALF_DAMAGE;
		case WATER:
			return NORMAL_DAMAGE;
		case GRASS:
			return DOUBLE_DAMAGE;
		case ELECTRIC:
			return NORMAL_DAMAGE;
		case PSYCHIC:
			return DOUBLE_DAMAGE;
		case ICE:
			return NORMAL_DAMAGE;
		case DRAGON:
			return NORMAL_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

	private String ghostAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NO_DAMAGE;
		case FIGHTING:
			return NORMAL_DAMAGE;
		case FLYING:
			return NORMAL_DAMAGE;
		case POISON:
			return NORMAL_DAMAGE;
		case GROUND:
			return NORMAL_DAMAGE;
		case ROCK:
			return NORMAL_DAMAGE;
		case BUG:
			return NORMAL_DAMAGE;
		case GHOST:
			return DOUBLE_DAMAGE;
		case FIRE:
			return NORMAL_DAMAGE;
		case WATER:
			return NORMAL_DAMAGE;
		case GRASS:
			return NORMAL_DAMAGE;
		case ELECTRIC:
			return NORMAL_DAMAGE;
		case PSYCHIC:
			return NO_DAMAGE;
		case ICE:
			return NORMAL_DAMAGE;
		case DRAGON:
			return NORMAL_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

	private String fireAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NORMAL_DAMAGE;
		case FIGHTING:
			return NORMAL_DAMAGE;
		case FLYING:
			return NORMAL_DAMAGE;
		case POISON:
			return NORMAL_DAMAGE;
		case GROUND:
			return NORMAL_DAMAGE;
		case ROCK:
			return HALF_DAMAGE;
		case BUG:
			return DOUBLE_DAMAGE;
		case GHOST:
			return NORMAL_DAMAGE;
		case FIRE:
			return HALF_DAMAGE;
		case WATER:
			return HALF_DAMAGE;
		case GRASS:
			return DOUBLE_DAMAGE;
		case ELECTRIC:
			return NORMAL_DAMAGE;
		case PSYCHIC:
			return NORMAL_DAMAGE;
		case ICE:
			return DOUBLE_DAMAGE;
		case DRAGON:
			return HALF_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

	private String waterAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NORMAL_DAMAGE;
		case FIGHTING:
			return NORMAL_DAMAGE;
		case FLYING:
			return NORMAL_DAMAGE;
		case POISON:
			return NORMAL_DAMAGE;
		case GROUND:
			return DOUBLE_DAMAGE;
		case ROCK:
			return DOUBLE_DAMAGE;
		case BUG:
			return NORMAL_DAMAGE;
		case GHOST:
			return NORMAL_DAMAGE;
		case FIRE:
			return DOUBLE_DAMAGE;
		case WATER:
			return HALF_DAMAGE;
		case GRASS:
			return HALF_DAMAGE;
		case ELECTRIC:
			return NORMAL_DAMAGE;
		case PSYCHIC:
			return NORMAL_DAMAGE;
		case ICE:
			return NORMAL_DAMAGE;
		case DRAGON:
			return HALF_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

	private String grassAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NORMAL_DAMAGE;
		case FIGHTING:
			return NORMAL_DAMAGE;
		case FLYING:
			return HALF_DAMAGE;
		case POISON:
			return HALF_DAMAGE;
		case GROUND:
			return DOUBLE_DAMAGE;
		case ROCK:
			return DOUBLE_DAMAGE;
		case BUG:
			return HALF_DAMAGE;
		case GHOST:
			return NORMAL_DAMAGE;
		case FIRE:
			return HALF_DAMAGE;
		case WATER:
			return DOUBLE_DAMAGE;
		case GRASS:
			return HALF_DAMAGE;
		case ELECTRIC:
			return NORMAL_DAMAGE;
		case PSYCHIC:
			return NORMAL_DAMAGE;
		case ICE:
			return NORMAL_DAMAGE;
		case DRAGON:
			return HALF_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

	private String electricAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NORMAL_DAMAGE;
		case FIGHTING:
			return NORMAL_DAMAGE;
		case FLYING:
			return DOUBLE_DAMAGE;
		case POISON:
			return NORMAL_DAMAGE;
		case GROUND:
			return NO_DAMAGE;
		case ROCK:
			return NORMAL_DAMAGE;
		case BUG:
			return NORMAL_DAMAGE;
		case GHOST:
			return NORMAL_DAMAGE;
		case FIRE:
			return NORMAL_DAMAGE;
		case WATER:
			return DOUBLE_DAMAGE;
		case GRASS:
			return HALF_DAMAGE;
		case ELECTRIC:
			return HALF_DAMAGE;
		case PSYCHIC:
			return NORMAL_DAMAGE;
		case ICE:
			return NORMAL_DAMAGE;
		case DRAGON:
			return HALF_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

	private String psychicAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NORMAL_DAMAGE;
		case FIGHTING:
			return DOUBLE_DAMAGE;
		case FLYING:
			return NORMAL_DAMAGE;
		case POISON:
			return DOUBLE_DAMAGE;
		case GROUND:
			return NORMAL_DAMAGE;
		case ROCK:
			return NORMAL_DAMAGE;
		case BUG:
			return NORMAL_DAMAGE;
		case GHOST:
			return NORMAL_DAMAGE;
		case FIRE:
			return NORMAL_DAMAGE;
		case WATER:
			return NORMAL_DAMAGE;
		case GRASS:
			return NORMAL_DAMAGE;
		case ELECTRIC:
			return NORMAL_DAMAGE;
		case PSYCHIC:
			return HALF_DAMAGE;
		case ICE:
			return NORMAL_DAMAGE;
		case DRAGON:
			return NORMAL_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

	private String iceAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NORMAL_DAMAGE;
		case FIGHTING:
			return NORMAL_DAMAGE;
		case FLYING:
			return DOUBLE_DAMAGE;
		case POISON:
			return NORMAL_DAMAGE;
		case GROUND:
			return DOUBLE_DAMAGE;
		case ROCK:
			return NORMAL_DAMAGE;
		case BUG:
			return NORMAL_DAMAGE;
		case GHOST:
			return NORMAL_DAMAGE;
		case FIRE:
			return NORMAL_DAMAGE;
		case WATER:
			return HALF_DAMAGE;
		case GRASS:
			return DOUBLE_DAMAGE;
		case ELECTRIC:
			return NORMAL_DAMAGE;
		case PSYCHIC:
			return NORMAL_DAMAGE;
		case ICE:
			return HALF_DAMAGE;
		case DRAGON:
			return DOUBLE_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}

	private String dragonAttack(String dType) {
		switch (dType) {
		case NORMAL:
			return NORMAL_DAMAGE;
		case FIGHTING:
			return NORMAL_DAMAGE;
		case FLYING:
			return NORMAL_DAMAGE;
		case POISON:
			return NORMAL_DAMAGE;
		case GROUND:
			return NORMAL_DAMAGE;
		case ROCK:
			return NORMAL_DAMAGE;
		case BUG:
			return NORMAL_DAMAGE;
		case GHOST:
			return NORMAL_DAMAGE;
		case FIRE:
			return NORMAL_DAMAGE;
		case WATER:
			return NORMAL_DAMAGE;
		case GRASS:
			return NORMAL_DAMAGE;
		case ELECTRIC:
			return NORMAL_DAMAGE;
		case PSYCHIC:
			return NORMAL_DAMAGE;
		case ICE:
			return NORMAL_DAMAGE;
		case DRAGON:
			return DOUBLE_DAMAGE;
		default:
			return NORMAL_DAMAGE;
		}
	}
}
