package in.marwaadi.service.util;

import java.text.MessageFormat;

import in.marwaadi.service.MessageService;

/**
 * @author anil.agrawal
 *
 */
public final class MessageUtil {

	private static MessageService messageService;

	private MessageUtil() {
		super();
	}

	/**
	 * @author anil.agrawal
	 * @param messageService
	 */
	public static void setMessageService(MessageService messageService) {
		MessageUtil.messageService = messageService;
	}

	/**
	 * @author anil.agrawal
	 * @param key
	 * @param arguments
	 * @return
	 */
	public static String generateSimpleMessage(String key, Object[] arguments) {
		return MessageFormat.format(MessageUtil.messageService.getMessage(key), arguments);
	}

	/**
	 * @author anil.agrawal
	 * @param key
	 * @return
	 */
	public static String generateSimpleMessage(String key) {
		return MessageUtil.messageService.getMessage(key);
	}
}
