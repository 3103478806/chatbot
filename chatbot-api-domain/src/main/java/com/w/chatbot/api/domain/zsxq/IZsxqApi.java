package com.w.chatbot.api.domain.zsxq;

import com.w.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOError;
import java.io.IOException;

public interface IZsxqApi {
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicTD(String groupId, String cookie) throws IOError, IOException;

    boolean answer(String groupId,String cookie,String topicID,String text,boolean silenced) throws IOError, IOException;
}
