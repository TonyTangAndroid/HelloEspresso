package com.dannyroa.espresso_samples.recyclerview;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Test class showcasing some {@link RecyclerViewActions} from Espresso.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SelectionActivityTest {

  private static final int ITEM_BELOW_THE_FOLD = 40;


  @Rule
  public ActivityScenarioRule<SelectionActivity> activityScenarioRule =
      new ActivityScenarioRule<SelectionActivity>(SelectionActivity.class);

  @Test
  public void scrollToItemBelowFold_checkItsText() {
    // First scroll to the position that needs to be matched and click on it.
    onView(ViewMatchers.withId(R.id.recycler_view))
        .perform(RecyclerViewActions.actionOnItemAtPosition(ITEM_BELOW_THE_FOLD, click()));

    // Match the text in an item below the fold and check that it's displayed.
    String itemElementText = getApplicationContext().getResources().getString(
        R.string.item_element_text) + String.valueOf(ITEM_BELOW_THE_FOLD);
    onView(withText(itemElementText)).check(matches(isDisplayed()));
  }

  @Test
  public void itemInMiddleOfList_hasSpecialText() {
    // First, scroll to the view holder using the isInTheMiddle matcher.
    onView(ViewMatchers.withId(R.id.recycler_view))
        .perform(RecyclerViewActions.scrollToHolder(isInTheMiddle()));

    // Check that the item has the special text.
    String middleElementText =
        getApplicationContext().getResources().getString(R.string.middle);
    onView(withText(middleElementText)).check(matches(isDisplayed()));
  }

  /**
   * Matches the {@link CustomAdapter.ViewHolder}s in the middle of the list.
   */
  private static Matcher<CustomAdapter.ViewHolder> isInTheMiddle() {
    return new TypeSafeMatcher<CustomAdapter.ViewHolder>() {
      @Override
      protected boolean matchesSafely(CustomAdapter.ViewHolder customHolder) {
        return customHolder.getIsInTheMiddle();
      }

      @Override
      public void describeTo(Description description) {
        description.appendText("item in the middle");
      }
    };
  }
}