package com.w.chatbot.api.domain.openai;

import java.io.IOException;

public interface IOpenAI {
    String doChatGPT(String question) throws IOException;

}
