package com.dannyroa.espresso_samples.recyclerview;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

  public static List<Team> list() {
    List<Team> teams = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      teams.add(create("USA", i));
      teams.add(create("Belgium", i));
      teams.add(create("Germany", i));

      teams.add(create("Philippines", i));
      teams.add(create("Australia", i));
      teams.add(create("Costa Rica", i));

      teams.add(create("Mexico", i));
      teams.add(create("Korea", i));
      teams.add(create("Brazil", i));

      teams.add(create("Chile", i));
      teams.add(create("Uruguay", i));
      teams.add(create("Colombia", i));
    }
    return teams;
  }

  private static Team create(String chile, int index) {
    return new Team(formatPrefix(index) + chile);
  }

  private static String formatPrefix(int index) {
    return index == 0 ? "" : index + ":";
  }
}
