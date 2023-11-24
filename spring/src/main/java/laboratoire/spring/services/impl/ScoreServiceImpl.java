package laboratoire.spring.services.impl;

import laboratoire.spring.models.entities.Score;
import laboratoire.spring.repositories.ScoreRepository;
import laboratoire.spring.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public Score saveScore(Score score){
        return scoreRepository.save(score);
    }

    @Override
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    @Override
    public Score getScoreById(Long id) {
        return scoreRepository.findById(id).orElse(null);
    }

    @Override
    public Score updateScore(Score score, Long id) {
        Score existingScore = scoreRepository.findById(id).orElse(null);
        if (existingScore != null) {
            existingScore.setJoueur(score.getJoueur());
            existingScore.setTournoi(score.getTournoi());
            existingScore.setNombreVictoires(score.getNombreVictoires());
            existingScore.setNombreDefaites(score.getNombreDefaites());
            existingScore.setNombreEgalites(score.getNombreEgalites());
            existingScore.setPoints(score.getPoints());
            return scoreRepository.save(existingScore);
        }
        return null;
    }
    @Override
    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }
}
