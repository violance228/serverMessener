package com.konex.messenger.service.Message;

import com.konex.messenger.entity.MessageCache;
import com.konex.messenger.entity.user.Message;
import com.konex.messenger.entity.user.User;
import com.konex.messenger.repository.MessageCacheRepository;
import com.konex.messenger.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */

@Service
public class MessageCacheServiceImpl implements MessageCacheService {

    @Autowired
    private MessageCacheRepository messageRepository;

    @Override
    public List<MessageCache> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<MessageCache> findAll(Specification specification) {
        return null;
    }

    @Override
    public MessageCache findById(Long id) {
        return messageRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public void save(MessageCache messageCache) {
        messageRepository.save(messageCache);
    }

    @Override
    public void update(MessageCache messageCache) {

    }

    @Override
    public void saveList(List<MessageCache> elementList) {

    }

    @Override
    public Stream<MessageCache> streamAll() {
        return null;
    }

    @Override
    public void deleteAll() {
        messageRepository.deleteAll();
    }

    @Override
    public List<MessageCache> getAllByFromUserAndForUserOrderByWasSentAsc(User fromUser, Long forUser) {
        return messageRepository.getAllByFromUserAndForUserOrderByWasSentAsc(fromUser, forUser);
    }
}
