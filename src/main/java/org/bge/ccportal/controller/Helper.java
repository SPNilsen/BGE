/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bge.ccportal.controller;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author seannils1
 */
public class Helper {

    public static String outputRequestParams(HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        StringBuilder sb = new StringBuilder();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            sb.append(paramName)
                .append(": ");
            String[] paramValues = request.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                sb.append(paramValues[i]);
            }
        }
        return sb.toString();
    }
}
