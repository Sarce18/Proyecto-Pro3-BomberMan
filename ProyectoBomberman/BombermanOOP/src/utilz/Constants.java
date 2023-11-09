package utilz;

public class Constants {

	public static class Directions {
		public static final int UP = 0;
		public static final int DOWN = 4;
		public static final int LEFT = 2;
		public static final int RIGHT = 3;
	}

	public static class PlayerConstants {
		//public static final int RUNNING = 3;
		public static final int LEFTP = 2;
		public static final int RIGHTP = 3;
		public static final int UPP = 0;
		public static final int IDLE = 4;
		public static final int DOWNP = 1;
		//public static final int JUMP = 2;
		//public static final int FALLING = 3;
		//public static final int GROUND = 4;
		//public static final int HIT = 5;
		//public static final int ATTACK_1 = 6;
		//public static final int ATTACK_JUMP_1 = 7;
		//public static final int ATTACK_JUMP_2 = 8;

		public static int GetSpriteAmount(int player_action) {
			switch (player_action) {
			
			case LEFTP:
			case RIGHTP:
			case UPP:
			case DOWNP:
				return 4;
			//case IDLE:
			//	return 1;
			//case JUMP:
			//case ATTACK_1:
			//case ATTACK_JUMP_1:
			//case ATTACK_JUMP_2:
			//	return 3;
			//case GROUND:
			//	return 2;
			//case FALLING:
			default:
				return 1;
			}
		}


	}
}
