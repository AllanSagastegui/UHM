module.exports = {
  extends: ['@commitlint/config-conventional'],
  rules: {
    'type-enum': [
      2,
      'always',
      [
        'feat',
        'fix',
        'style',
        'refactor',
        'perf',
        'test',
        'chore',
        'ci',
        'workflow',
        'types',
        'wip',
        'revert',
        'docs'
      ]
    ],
    'scope-empty': [0],
    'subject-case': [2, 'always', 'sentence-case'],
    'subject-max-length': [2, 'always', 72],
  },
};