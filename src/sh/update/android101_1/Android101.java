package sh.update.android101_1;

import java.util.Arrays;

import android.widget.TextView;

public class Android101 extends Android101Helper {
	
	public Android101(TextView textview) {
		super(textview);
	}

	public void run(String input) {
		try {
			final int size = Integer.valueOf(input);
			if (size < 1) {
				print("size must be higher than 0.\n");
			}
			
			int[][] array = new int[size][size];
			int x = 0;
			int y = 0;
			
			final int RIGHT = 0;
			final int DOWN = 1;
			final int LEFT = 2;
			final int UP = 3;
			int direction = RIGHT;
			
			for (int i = 1; i <= size*size; i++) {
				array[x][y] = i;
				switch (direction) {
				case RIGHT:
					if (x < size-1 && array[x+1][y] == 0) {
						x++;
					} else {
						direction = DOWN;
						y++;
					}
					break;
				case DOWN:
					if (y < size-1 && array[x][y+1] == 0) {
						y++;
					} else {
						direction = LEFT;
						x--;
					}
					break;
				case LEFT:
					if (x > 0 && array[x-1][y] == 0) {
						x--;
					} else {
						direction = UP;
						y--;
					}
					break;
				case UP:
					if (y > 0 && array[x][y-1] == 0) {
						y--;
					} else {
						direction = RIGHT;
						x++;
					}
					break;

				default:
					break;
				}
			}
			
			final int maxLength = String.valueOf(size*size).length();
			for (int j = 0; j < size; j++) {
				for (int i = 0; i < size; i++) {
					final String number = String.valueOf(array[i][j]);
					String headerSpace = " ";
					for (int k = 0; k < maxLength-number.length(); k++) {
						headerSpace += " ";
					}
					print(headerSpace + array[i][j]);
				}
				print("\n");
			}	
		} catch (Exception e) {
			print("Please inuput size correctly.\n");
			e.printStackTrace();
		}
		return;
	}
}
