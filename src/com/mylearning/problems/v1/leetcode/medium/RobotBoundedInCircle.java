package com.mylearning.problems.v1.leetcode.medium;

public class RobotBoundedInCircle {

  public static void main(String[] args) {
    String s = "GGLLGG";  // GL -> does not point to north
    Direction d = Direction.NORTH;
    int[] pos = {0, 0};
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (c == 'G') move(d, pos);
      else d = turn(d, c);
    }
    System.out.println(pos[0] == 0 && pos[1] == 0 || d != Direction.NORTH);
  }

  private static void move(Direction d, int[] pos) {
    if (d == Direction.NORTH) pos[1]++;
    else if (d == Direction.SOUTH) pos[1]--;
    else if (d == Direction.EAST) pos[0]++;
    else pos[0]--;
  }

  private static Direction turn(Direction d, char c) {
    if (c == 'L') {
      if (d == Direction.NORTH) return Direction.WEST;
      else if (d == Direction.SOUTH) return Direction.EAST;
      else if (d == Direction.EAST) return Direction.NORTH;
      else if (d == Direction.WEST) return Direction.SOUTH;
      return null;
    } else {
      if (d == Direction.NORTH) return Direction.EAST;
      else if (d == Direction.SOUTH) return Direction.WEST;
      else if (d == Direction.EAST) return Direction.SOUTH;
      else if (d == Direction.WEST) return Direction.NORTH;
      return null;
    }
  }

  //Another simple solution
  public boolean isRobotBounded(String instructions) {
    int dir = 0, x = 0, y = 0;
    for(char c : instructions.toCharArray()) {
      if(c == 'L') {
        dir = (dir + 1) % 4;
      } else if (c == 'R') {
        dir = (dir + 3) % 4;
      } else if (dir == 0) {
        y++;
      } else if (dir == 1) {
        x--;
      } else if (dir == 2) {
        y--;
      } else {
        x++;
      }
    }
    return dir != 0 || (x == 0 && y == 0);
  }
}

enum Direction {
  NORTH, SOUTH, EAST, WEST;
}
