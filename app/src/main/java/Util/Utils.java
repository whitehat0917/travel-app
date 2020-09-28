package Util;

/**
 * Created by kamlesh kumar garg on 04-06-2015.
 */

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import objects.Friend;
import tie.hackathon.travelguide.R;

public class Utils {

// validating email id
    public static boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    public static boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 2) {
            return true;
        }
        return false;
    }

    /*
    open in browser
    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
startActivity(browserIntent);
     */


    public static String readStream(InputStream in) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {

            String nextLine = "";
            while ((nextLine = reader.readLine()) != null) {
                sb.append(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


	//is network available?
   public static boolean isNetworkAvailable(Activity a) {
       ConnectivityManager connectivityManager
               = (ConnectivityManager) a.getSystemService(a.CONNECTIVITY_SERVICE);
       NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
       return activeNetworkInfo != null && activeNetworkInfo.isConnected();
   }


//hide soft keyboard
    public static void hideKeyboard(Activity th) {
        View view = th.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) th.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


   public static String encrypt(String Data) throws UnsupportedEncodingException {
       byte[] data = Data.getBytes("UTF-8");
       String base64 = Base64.encodeToString(data, Base64.DEFAULT);
       return base64;
   }
   public static String decryt(String d) throws UnsupportedEncodingException {
       byte[] data = Base64.decode(d, Base64.DEFAULT);
       String text = new String(data, "UTF-8");
       return text;
   }



   /* public static final List<Friend> friends = new ArrayList<>();

    static {
        friends.add(new Friend(R.drawable.delhi, "ANASTASIA", R.color.sienna, "Sport", "Literature", "Music", "Art", "Technology"));
        friends.add(new Friend(R.drawable.delhi, "IRENE", R.color.saffron, "Travelling", "Flights", "Books", "Painting", "Design"));
        friends.add(new Friend(R.drawable.delhi, "KATE", R.color.green, "Sales", "Pets", "Skiing", "Hairstyles", "Сoffee"));
        friends.add(new Friend(R.drawable.delhi, "PAUL", R.color.pink, "Android", "Development", "Design", "Wearables", "Pets"));
        friends.add(new Friend(R.drawable.delhi, "DARIA", R.color.orange, "Design", "Fitness", "Healthcare", "UI/UX", "Chatting"));
        friends.add(new Friend(R.drawable.delhi, "KIRILL", R.color.saffron, "Development", "Android", "Healthcare", "Sport", "Rock Music"));
        friends.add(new Friend(R.drawable.delhi, "JULIA", R.color.green, "Cinema", "Music", "Tatoo", "Animals", "Management"));
        friends.add(new Friend(R.drawable.delhi, "YALANTIS", R.color.purple, "Android", "IOS", "Application", "Development", "Company"));
    }
*/

}
