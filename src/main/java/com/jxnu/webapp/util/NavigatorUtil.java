package com.jxnu.webapp.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by puchunwei on 15/12/26.
 */
public class NavigatorUtil {

    public static void redirect(HttpServletResponse response, String uri) throws IOException {
        response.sendRedirect(Constans.applicationName+uri);
    }

}
