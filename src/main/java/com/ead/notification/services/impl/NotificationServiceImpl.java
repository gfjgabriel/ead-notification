package com.ead.notification.services.impl;

import com.ead.notification.enums.NotificationStatus;
import com.ead.notification.models.NotificationModel;
import com.ead.notification.repositories.NotificationRepository;
import com.ead.notification.services.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;

    public NotificationServiceImpl(NotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public NotificationModel saveNotification(NotificationModel notificationModel) {
        return repository.save(notificationModel);
    }

    @Override
    public Page<NotificationModel> findAllNotificationsByUser(UUID userId, Pageable pageable) {
        return repository.findAllByUserIdAndNotificationStatus(userId, NotificationStatus.CREATED, pageable);
    }

    @Override
    public Optional<NotificationModel> findByNotificationIdAndUserId(UUID notificationId, UUID userId) {
        return repository.findByNotificationIdAndUserId(notificationId, userId);
    }
}
