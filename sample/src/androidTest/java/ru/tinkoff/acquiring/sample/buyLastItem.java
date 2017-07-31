package ru.tinkoff.acquiring.sample;

/**
 * Created by ayugazin on 30.07.17.
 */

/**
 *   Автотест
 *   Тип: смоук критикал. Позитивный.
 *   Тест-дизайн: граничные значения
 *   Название: Покупка последнего товара. Карта VISA
 */

import android.app.Application;
import android.renderscript.Sampler;
import android.support.test.espresso.ViewAssertion;
import android.test.ApplicationTestCase;
import org.junit.Test;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.KeyEvent;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.tinkoff.acquiring.sample.ui.MainActivity;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withTagKey;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class buyLastItem {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void test() throws Exception {
        // Проверим отображение ListView на экране
        onView(withId(R.id.lv_books))
                .check(matches(isDisplayed()));

        //  Тапаем на кнопку details, элемента листВью на 6 позиции (помним, что элементы начинаются с 0 позиции)
        onData(anything())
                .inAdapterView(withId(R.id.lv_books))
                .atPosition(5)
                .onChildView(withId(R.id.tv_book_details))
                .perform(click());

        // жмем купить сейчас
        onView(withId(R.id.btn_buy_now))
                .perform(click());

        // ждем загрузки экрана с вводом карты
        Thread.sleep(3000);

        // Вводим номер карты VISA
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_4));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_3));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_0));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_0));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_0));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_0));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_0));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_0));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_0));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_0));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_0));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_0));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_0));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_7));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_7));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_7));

        Thread.sleep(2000); // ждем пока появится поле с датой карты

        // вводим expDate
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_1));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_2));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_2));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_0));

        Thread.sleep(2000); // ждем пока появится поле с CVC карты

        // вводим cvc
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_7));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_4));
        onView(withId(R.id.acq_gl_keys))
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_9));

        Thread.sleep(2000);

        // жмем оплатить
        onView(withId(R.id.btn_pay))
                .perform(click());

        // ждем оплаты
        Thread.sleep(5000);

        // ищем на экране информацию об успешной оплате товара
        onView(withId(R.id.tv_confirm))
                .check(matches(isDisplayed()));
    }
}