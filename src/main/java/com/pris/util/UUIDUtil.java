/**
 * 
 */
package com.pris.util;

import java.util.UUID;

/**
 * @author LO
 *
 */
public class UUIDUtil {
	public static String uuid32(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
