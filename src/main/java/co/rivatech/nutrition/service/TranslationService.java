package co.rivatech.nutrition.service;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import org.springframework.stereotype.Service;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Service
public class TranslationService {

    public String translate(final String word) {
        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Translation translation = translate.translate(word, Translate.TranslateOption.sourceLanguage("en"),
                                                      Translate.TranslateOption.targetLanguage("hi"));
        return translation.getTranslatedText();
    }
}