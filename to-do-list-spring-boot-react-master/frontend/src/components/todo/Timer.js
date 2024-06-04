// Timer.js

import React, { useState, useEffect } from 'react';

const Timer = ({ startTime, onTimerEnd }) => {
  const [timeLeft, setTimeLeft] = useState(startTime);

  useEffect(() => {
    const timer = setInterval(() => {
      setTimeLeft(prevTimeLeft => prevTimeLeft - 1);
    }, 1000);

    return () => clearInterval(timer);
  }, []);

  useEffect(() => {
    if (timeLeft === 0) {
      onTimerEnd(); // Call the callback when timer ends
    }
  }, [timeLeft, onTimerEnd]);

  return <div>Time Left: {timeLeft} seconds</div>;
};

export default Timer;
