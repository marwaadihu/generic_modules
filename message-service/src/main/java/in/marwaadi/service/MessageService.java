package in.marwaadi.service;

import java.util.Locale;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import in.marwaadi.service.util.MessageUtil;

/**
 * @author anil.agrawal
 *
 */
@Service
public class MessageService implements InitializingBean {

	private MessageSource messageSource;

	public MessageService(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		MessageUtil.setMessageService(this);
	}

	/**
	 * @author anil.agrawal
	 * @param id
	 * @return
	 */
	public String getMessage(String id) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(id, null, locale);
	}
}
