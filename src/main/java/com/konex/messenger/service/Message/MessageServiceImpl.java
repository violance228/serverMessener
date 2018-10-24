package com.konex.messenger.service.Message;

import com.konex.messenger.entity.user.Message;
import com.konex.messenger.entity.user.User;
import com.konex.messenger.repository.MessageRepository;
import com.konex.messenger.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> findAll(Specification specification) {
        return null;
    }

    @Override
    public Message findById(Long id) {
        return messageRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void update(Message message) {
        messageRepository.saveAndFlush(message);
    }

    @Override
    public void saveList(List<Message> elementList) {
        messageRepository.saveAll(elementList);
    }

    @Override
    public Stream<Message> streamAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Message> getAllMessageWithUser(Long forUserId, Long fromUserId) {

        User fromUser = userService.findById(fromUserId);
        User forUser = userService.findById(forUserId);
        List<Message> messageList = messageRepository.getAllByUserAndForUserOrderByWasSentAsc(fromUser, forUser.getId());
        messageList.addAll(messageRepository.getAllByUserAndForUserOrderByWasSentAsc(forUser, fromUser.getId()));
        return messageList;
    }
}
