package com.example.zanatbizkod.ui

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar

fun View.hideKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken, 0)
}

fun Int.navigate(view: View) {
    Navigation.findNavController(view).navigate(this)
}

fun NavController.backToPreviousScreen() {
    popBackStack()
}

fun String.snackbar(view: View) {
    Snackbar.make(view, this, Snackbar.LENGTH_SHORT).show()
}

/*fun ImageView.navDrawer(activity: FragmentActivity?) {
    setImageResource(R.drawable.ic_menu)
    setOnClickListener {
        activity?.drawerLayout?.openDrawer(GravityCompat.START)
    }
}*/

/*fun openInstagram(context: Context) {
    val appUri = Uri.parse(context.getString(R.string.instagram_app_url))
    val browserUri = Uri.parse(context.getString(R.string.instagram_web_url))
    val compName1 = context.getString(R.string.instagram_comp1)
    val compName2 = context.getString(R.string.instagram_comp2)
    openApplication(appUri, browserUri, compName1, compName2, context)
}

fun openFacebook(context: Context) {
    val appUri = Uri.parse(context.getString(R.string.facebook_app_url))
    val browserUri = Uri.parse(context.getString(R.string.facebook_web_url))
    val compName1 = context.getString(R.string.facebook_comp1)
    val compName2 = context.getString(R.string.facebook_comp2)
    openApplication(appUri, browserUri, compName1, compName2, context)
}*/

fun openApplication(
    appUri: Uri,
    browserUri: Uri,
    compName1: String,
    compName2: String,
    context: Context
) {
    val app = Intent(Intent.ACTION_VIEW, appUri)
    val browser = Intent(Intent.ACTION_VIEW, browserUri)
    app.component = ComponentName(
        compName1,
        compName2
    )
    runCatching {
        startActivity(context, app, null)
    }.onFailure {
        startActivity(context, browser, null)
    }
}

/*fun String.getImage(context: Context, imageView: ImageView) {
    val url = "${Consts.BASE_URL}${Consts.GET_IMAGE_URL}$this"

    Glide.with(context)
        .load(url)
        .override(SIZE_ORIGINAL)
        .placeholder(R.drawable.placeholder)
        .into(imageView)
}

fun String.getSmallImage(context: Context, imageView: ImageView) {
    val url = "${Consts.BASE_URL}${Consts.GET_SMALL_IMAGE_URL}$this"

    Glide.with(context)
        .load(url)
        .override(SIZE_ORIGINAL)
        .placeholder(R.drawable.test_meal_image)
        .into(imageView)
}

fun Long?.isTokenValid(): Boolean {
    if(this != null) {
        return when(Date().compareTo(Date(this))) {
            -1 -> true
            else -> false
        }
    }
    return false
}

fun Long.getDayOfWeekAndDate(context: Context): String {
    val calendar = Calendar.getInstance().apply { timeInMillis = this@getDayOfWeekAndDate }
    val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK).getDayOfWeek(context)
    val date = longToFormattedDate(this, context.getString(R.string.day_month_format))
    return context.getString(R.string.day_of_week_and_date, dayOfWeek, date)
}

fun Int.getDayOfWeek(context: Context): String =
    when(this) {
        1 -> context.getString(R.string.sunday)
        2 -> context.getString(R.string.monday)
        3 -> context.getString(R.string.tuesday)
        4 -> context.getString(R.string.wednesday)
        5 -> context.getString(R.string.thursday)
        6 -> context.getString(R.string.friday)
        7 -> context.getString(R.string.saturday)
        else -> ""
    }

fun getDateToday(): Long =
    Calendar.getInstance().apply {
        timeZone = TimeZone.getTimeZone("GMT")
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.run {
        this.timeInMillis * 10000 + Consts.TICKS_AT_EPOCH
    }

fun getTodayInMs(): Long = MaterialDatePicker.todayInUtcMilliseconds()

fun longToFormattedDate(ms: Long, format: String): String {
    val dateFormat = SimpleDateFormat(format, Locale.ENGLISH)
    return dateFormat.format(Date(ms))
}

fun Chip.today() {
    text = longToFormattedDate(getTodayInMs(), context.getString(R.string.day_month_format))
}

fun Chip.calendar(fragmentManager: FragmentManager) {
    setOnClickListener {
        val listValidators = listOf(
            DateValidatorPointForward.now(),
            DateValidatorPointBackward.before(nextTenDaysCalculator(getTodayInMs())),
            CustomDateValidator
        )
        val validators = CompositeDateValidator.allOf(listValidators)

        val constraintsBuilder =
            CalendarConstraints.Builder()
                .setValidator(validators)

        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText(context.getString(R.string.pick_a_date))
                .setSelection(getTodayInMs())
                .setCalendarConstraints(constraintsBuilder.build())
                .build()

        datePicker.show(fragmentManager, "calendarTag")

        datePicker.addOnPositiveButtonClickListener {
            text = longToFormattedDate(it, context.getString(R.string.day_month_format))
        }
    }
}*/
