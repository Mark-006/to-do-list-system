import React, { useState, useEffect } from 'react';
import moment from 'moment';
import Timer from './Timer'; // Import the Timer component

const TaskComponent = ({ task }) => {
  const [timeRemaining, setTimeRemaining] = useState('');

  useEffect(() => {
    if (!task.completed) {
      const intervalId = setInterval(() => {
        const now = moment();
        const targetDate = moment(task.targetDate);
        const duration = moment.duration(targetDate.diff(now));
        const hours = Math.floor(duration.asHours());
        const minutes = moment.utc(duration.asMilliseconds()).format('mm');
        const seconds = moment.utc(duration.asMilliseconds()).format('ss');
        setTimeRemaining(`${hours}:${minutes}:${seconds}`);

        if (duration.asMilliseconds() <= 0) {
          clearInterval(intervalId);
          setTimeRemaining('Expired');
        }
      }, 1000);

      return () => clearInterval(intervalId);
    }
  }, [task.completed, task.targetDate]);

  const handleTimerEnd = () => {
    // Implement what should happen when the timer ends (optional)
  };

  return (
    <div className="task">
      <div className="task-title">{task.title}</div>
      {!task.completed && <Timer startTime={timeRemaining} onTimerEnd={handleTimerEnd} />} {/* Render Timer only for incomplete tasks */}
      <div className="task-timer">{timeRemaining}</div>
    </div>
  );
};

export default TaskComponent;
