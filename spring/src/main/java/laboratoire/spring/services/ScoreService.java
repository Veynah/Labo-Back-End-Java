package laboratoire.spring.services;

import laboratoire.spring.models.entities.Score;

import java.util.List;

public interface ScoreService {
    Score saveScore(Score score);
    List<Score> getAllScores();
    Score getScoreById(Long id);
    Score updateScore(Score score, Long id);
    void deleteScore(Long id);
}
