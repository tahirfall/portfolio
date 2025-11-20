INSERT INTO users (id, first_name, last_name, profile, professional_summary, email, phone, resume)
VALUES (1, 'Tahir', 'Fall', 'Développeur fullstack passionné',
        'Développeur avec 5 ans.',
        'tahir.fall@example.com', '+221770000000', 'liencv')
    ON CONFLICT (id) DO UPDATE
                            SET first_name = EXCLUDED.first_name,
                            last_name = EXCLUDED.last_name,
                            profile = EXCLUDED.profile,
                            professional_summary = EXCLUDED.professional_summary,
                            email = EXCLUDED.email,
                            phone = EXCLUDED.phone,
                            resume = EXCLUDED.resume;
